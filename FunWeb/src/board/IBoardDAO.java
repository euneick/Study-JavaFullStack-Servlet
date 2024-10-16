package board;

import java.util.Vector;

public interface IBoardDAO {

	/**
	 * DB에 저장된 모든 글들을 조회
	 * @param keyField 검색 기준값
	 * @param keyword 검색어
	 * @return 조회한 결과들의 Vector 리스트
	 */
	public Vector<Object> getBoardList(String keyField, String keyword);
	
	/**
	 * DB에 새로운 게시글 추가
	 * @param boardBean 하나의 글 정보를 담은 Bean 객체
	 */
	public void insertBoard(BoardBean boardBean);
	
	/**
	 * 한 게시글을 수정하여 DB에 업데이트
	 * @param boardBean 하나의 글 정보를 담은 Bean 객체
	 */
	public void updateBoard(BoardBean boardBean);
	
	/**
	 * 한 게시글을 DB에서 삭제
	 * @param num 삭제할 글 번호
	 * @param id 작성자 아이디
	 * @param pwd 작성자 비밀번호
	 */
	public void deleteBoard(int num, String id, String pwd);
	
	/**
	 * DB에 작성되어 있는 주 게시글에 대한 새로운 답변글을 작성
	 * @param boardBean 하나의 글 정보를 담은 Bean 객체
	 */
	public void replyBoard(BoardBean boardBean);
}
