package ra.ss1_task1.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class SongDtoForm {
    private Long id;

    private String songName;
    private String singerName;

    private String songCategory;
    private MultipartFile songUrl;

    public SongDtoForm() {
    }

    public SongDtoForm(Long id, String songName, String singerName, String songCategory, MultipartFile songUrl) {
        this.id = id;
        this.songName = songName;
        this.singerName = singerName;
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

    public MultipartFile getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(MultipartFile songUrl) {
        this.songUrl = songUrl;
    }
}
