package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.Board;

@Repository
public class BoardMapperImpl implements BoardMapper {
    private final SqlSession sqlSession;
    private static final String NAMESPACE = "com.example.demo.mapper.BoardMapper";

    public BoardMapperImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void insertBoard(Board board) {
        sqlSession.insert(NAMESPACE + ".insertBoard", board);
    }

    @Override
    public List<Board> getAllBoards() {
        return sqlSession.selectList(NAMESPACE + ".getAllBoards");
    }

    @Override
    public Board getBoardById(int id) {
        return sqlSession.selectOne(NAMESPACE + ".getBoardById", id);
    }

    @Override
    public void updateBoard(Board board) {
        sqlSession.update(NAMESPACE + ".updateBoard", board);
    }

    @Override
    public void deleteBoard(int id) {
        sqlSession.delete(NAMESPACE + ".deleteBoard", id);
    }

    @Override
    public int getBoardCount() {
        return sqlSession.selectOne(NAMESPACE + ".getBoardCount");
    }

    @Override
    public List<Board> getBoardList(int offset, int limit) {
        return sqlSession.selectList(NAMESPACE + ".getBoardList", createParams(offset, limit));
    }
    

    private ParamMap createParams(int offset, int limit) {
        ParamMap params = new ParamMap();
        params.put("offset", offset);
        params.put("limit", limit);
        return params;
    }
}
