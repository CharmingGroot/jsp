package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.Board;

@Mapper
public interface BoardMapper {
    @Insert("INSERT INTO board (title, content, author, created_at, updated_at) VALUES (#{title}, #{content}, #{author}, #{createdAt}, #{updatedAt})")
    void insertBoard(Board board);

    @Select("SELECT * FROM board")
    List<Board> getAllBoards();

    @Select("SELECT * FROM board WHERE id = #{id}")
    Board getBoardById(@Param("id") int id);

    @Update("UPDATE board SET title = #{title}, content = #{content}, author = #{author}, updated_at = #{updatedAt} WHERE id = #{id}")
    void updateBoard(Board board);

    @Delete("DELETE FROM board WHERE id = #{id}")
    void deleteBoard(@Param("id") int id);
    
    @Select("SELECT COUNT(*) FROM board")
    int getBoardCount();

    @Select("SELECT * FROM board ORDER BY id DESC LIMIT #{offset}, #{limit}")
    List<Board> getBoardList(@Param("offset") int offset, @Param("limit") int limit);
}
