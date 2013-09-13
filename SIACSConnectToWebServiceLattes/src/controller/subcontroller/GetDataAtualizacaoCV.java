package controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SIACS;
import model.form.GetDataAtualizacaoCVForm;
import model.util.Mensagem;
import controller.AbstractCommand;

public class GetDataAtualizacaoCV extends AbstractCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SIACS siacs = SIACS.getInstance();
		String page = (String) request.getParameter("page");
		String frm_id = request.getParameter("frm_id");
		
		GetDataAtualizacaoCVForm gDACVForm = new GetDataAtualizacaoCVForm();
		gDACVForm.setId(frm_id);
		
		String retornoString = siacs.getDataAtualizacaoCV(gDACVForm);
		
		request.setAttribute("retornoString", retornoString);
		request.setAttribute("retorno", Mensagem.getErroAtual());
		request.getRequestDispatcher(page).forward(request, response);		
	}

}
