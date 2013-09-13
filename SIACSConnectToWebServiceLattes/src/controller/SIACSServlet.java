package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import controller.subcontroller.GetCurriculoCompactado;
import controller.subcontroller.GetCurriculoCompactadoPorUsuario;
import controller.subcontroller.GetDataAtualizacaoCV;
import controller.subcontroller.GetDataAtualizacaoCVPorUsuario;
import controller.subcontroller.GetIdentificadorCNPq;
import controller.subcontroller.GetIdentificadorCNPqPorUsuario;
import controller.subcontroller.GetOcorrenciaCV;
import controller.subcontroller.GetOcorrenciaCVPorUsuario;
import controller.subcontroller.SetEndPoint;
import controller.subcontroller.VerificarOperacao;

/**
 * Servlet implementation class SIACSServlet
 */
@WebServlet("/SIACSServlet")
public class SIACSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Hashtable commands;
       
    public SIACSServlet() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException{
    	super.init();
    	this.commands = new Hashtable();
    	AbstractCommand comando;
    	
    	comando = new VerificarOperacao();
    	this.commands.put("VerificarFuncao", comando);
    	
    	comando = new GetDataAtualizacaoCVPorUsuario();
    	this.commands.put("GetDataAtualizacaoCVPorUsuario", comando);
    	
    	comando = new GetDataAtualizacaoCV();
    	this.commands.put("GetDataAtualizacaoCV", comando);

    	comando = new GetCurriculoCompactadoPorUsuario();
    	this.commands.put("GetCurriculoCompactadoPorUsuario", comando);

    	comando = new GetCurriculoCompactado();
    	this.commands.put("GetCurriculoCompactado", comando);
    	
    	comando = new GetIdentificadorCNPqPorUsuario();
    	this.commands.put("GetIdentificadorCNPqPorUsuario", comando);

    	comando = new GetIdentificadorCNPq();
    	this.commands.put("GetIdentificadorCNPq", comando);
    	
    	comando = new GetOcorrenciaCVPorUsuario();
    	this.commands.put("GetOcorrenciaCVPorUsuario", comando);
    	
    	comando = new GetOcorrenciaCV();
    	this.commands.put("GetOcorrenciaCV", comando);
    	
    	comando = new SetEndPoint();
    	this.commands.put("SetEndPoint", comando);
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		try{
			AbstractCommand command = (AbstractCommand) commands.get(cmd);
			command.execute(request, response);
		}catch(Exception e){
			request.setAttribute("msgErro", "Erro grave de Sistema: Contate o Administrador \n"
					+ e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, 
					response);
			
		}
	}

}
