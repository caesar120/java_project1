package fileUpload;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardControl
 */
@WebServlet("/fileUpload/BoardControl2.do")
public class BoardControl2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardControl2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BoardDAO2 dao = new BoardDAO2();
		Board2 board  = new Board2();
		board.setNo(request.getParameter("no"));
		
		String action = request.getParameter("action");
		if(action == null || action.isEmpty() ) {
			System.out.print("잘못된 명령입니다.");
		} else if(action.equals("insForm")) {	//등록폼
			response.sendRedirect("deptIns.tile");
		} 
		//단건조회
		else if(action.equals("sel")) 
		{		
			//단건조회
			Board2 result = dao.getDB(Integer.parseInt(board.getNo()) );
			//상세보기폼으로
			request.setAttribute("board", result);
			request.getRequestDispatcher("boardSel.jsp").forward(request, response);
		} 
		else if(action.equals("list")) {		//전체처리
			ArrayList<Board2> datas = dao.getDBList();
			request.setAttribute("datas", datas);
			request.getRequestDispatcher("boardList.jsp").forward(request, response);
		}
		else if(action.equals("download")) {		//전체처리
			Board2 result = dao.getDB(Integer.parseInt( board.getNo()) );
			System.out.println(result);
			// 응답 헤더 다운로드로 설정
			response.reset();
			int filesize = 0;
			System.out.println(result.getOriginalfileName()+"====");
			String fileName = new String(result.getOriginalfileName().getBytes("utf-8"),
			"iso-8859-1");
			String realPath = "d:/upload/" + result.getUploadedfileName();
			
			//response header 설정 (attachment; filenamem, filesize
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName+"\"");
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setContentLength( filesize );
			response.setHeader("Pragma", "no-cache;");
			response.setHeader("Expires", "-1;");
			
			FileDownloadHelper2.copy(realPath, response.getOutputStream());
			
			response.getOutputStream().close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
