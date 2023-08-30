package ra.ss1_task1.model.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ra.ss1_task1.model.entity.Song;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SongRepository implements ISongRepository{

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.config.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Song> findAll() {
        String queryStr = "SELECT c from Song as c";
        TypedQuery<Song> query = entityManager.createQuery(queryStr,Song.class);
        return query.getResultList();
    }

    @Override
    public Song findByID(Long id) {
        // sử dụng các phương thức của đối tượng 1 cách tự động
        TypedQuery<Song> type = entityManager.createQuery("SELECT p FROM Song AS p WHERE p.id=:id", Song.class);
        type.setParameter("id",id);
        // lấy về 1 đối tương
        Song s = type.getSingleResult();
        return s;
    }

    @Override
    public void save(Song p) {
        // Khởi tạo các đối tượng để quản lí giao dịch
        Session session = null;
        Transaction transaction = null;
        try {
            // khởi tạo session (phiên)
            session = sessionFactory.openSession();
            // bắt đầu 1 giao dịch
            transaction = session.beginTransaction();
            if(p.getId()==null){
                // chức năng thêm mới
                session.save(p);
            }else {
                // chức năng update (liên quan đến copy)
                // lấy đối tượng cũ cần sửa ra
                Song old = findByID(p.getId());
                if(p.getSongUrl()==null){
                    p.setSongUrl(old.getSongUrl());
                }
                old.copy(p);
                session.saveOrUpdate(old);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.isActive();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Session session =null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction= session.beginTransaction();
            session.delete(findByID(id));
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction!=null){
                transaction.isActive();
            }
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
    }

