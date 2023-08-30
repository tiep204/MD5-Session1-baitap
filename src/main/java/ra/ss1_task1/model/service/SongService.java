package ra.ss1_task1.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import ra.ss1_task1.model.dto.SongDtoForm;
import ra.ss1_task1.model.entity.Song;
import ra.ss1_task1.model.repository.IGenericRepository;
import ra.ss1_task1.model.repository.ISongRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class SongService implements ISongService{
    private String pathMusic ="/Users/shmily/Desktop/MD5/SS1_task1/src/main/webapp/upload/";
    @Autowired
    private ISongRepository songRepository;
    @Override
    public List<Song> findAll() {
       return songRepository.findAll();
    }

    @Override
    public Song findByID(Long id) {
        return songRepository.findByID(id);
    }

    @Override
    public void save(SongDtoForm s) {
        // xử lí chuyển đổi
        // upload file
        String filename = null;
        if(!(s.getSongUrl().isEmpty())){
            filename = s.getSongUrl().getOriginalFilename();
            try {
                FileCopyUtils.copy(s.getSongUrl().getBytes(),new File(pathMusic+filename));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // chuyển từ dto thành entity
        Song song = new Song(s.getId(),s.getSingerName(),s.getSongName(),s.getSongCategory(),filename);
        songRepository.save(song);
    }

    @Override
    public void delete(Long id) {
    songRepository.delete(id);
    }
}
