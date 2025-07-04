package com.gn.mapper;

import java.util.List;

import com.gn.dto.Attach;
import com.gn.dto.Board;

public interface BoardMapper {
	List<Board> selecBoardList(Board param);
	int insertBoard(Board param);
	int insertAttach(Attach param);
	int selectBoardCount(Board param);
	Attach selectAttachByBoardNo(int boardNo);
	Board selectBoardOne(int boardNo);
	Attach selectAttachByAttachNo(int attachNo);
}
