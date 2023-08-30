package ra.ss1_task1.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String singerName;
    private String songName;

    private String songCategory;
    private String songUrl;

    public Song() {
    }

    public Song(Long id, String singerName, String songCategory, String songUrl) {
        this.id = id;
        this.singerName = singerName;
        this.songCategory = songCategory;
        this.songUrl = songUrl;
    }

    public Song(Long id, String singerName, String songName, String songCategory, String songUrl) {
        this.id = id;
        this.singerName = singerName;
        this.songName = songName;
        this.songCategory = songCategory;
        this.songUrl = songUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSongCategory() {
        return songCategory;
    }

    public void setSongCategory(String songCategory) {
        this.songCategory = songCategory;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }
    public void copy(Song s){
        this.id = s.getId();
        this.songName =s.getSongName();
        this.singerName=s.getSingerName();
        this.songCategory=s.getSongCategory();
        this.songUrl=s.getSongUrl();
    }
}
