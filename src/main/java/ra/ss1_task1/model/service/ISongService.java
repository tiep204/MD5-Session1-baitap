package ra.ss1_task1.model.service;

import ra.ss1_task1.model.dto.SongDtoForm;
import ra.ss1_task1.model.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findByID(Long id);
    void save(SongDtoForm s);
    void delete(Long id);
}
