package model.business;

public class Operacao {
	
	private String nome;
	private String page;
	
	public static final String PAGE_INDEX = "index.jsp";
	public static final String PAGE_GET_DATA_ATUALIZACAO_CV_POR_USUARIO = "operacoes/getdataatualizacaocvporusuario.jsp";
	public static final String PAGE_GET_DATA_ATUALIZACAO_CV = "operacoes/getdataatualizacaocv.jsp";
	public static final String PAGE_GET_CURRICULO_COMPACTADO_POR_USUARIO = "operacoes/getcurriculocompactadoporusuario.jsp";
	public static final String PAGE_GET_CURRICULO_COMPACTADO = "operacoes/getcurriculocompactado.jsp";
	public static final String PAGE_GET_IDENTIFICADOR_CNPQ_POR_USUARIO = "operacoes/getidentificadorcnpqporusuario.jsp";
	public static final String PAGE_GET_IDENTIFICADOR_CNPQ = "operacoes/getidentificadorcnpq.jsp";	
	public static final String PAGE_GET_OCORRENCIA_CV_POR_USUARIO = "operacoes/getocorrenciacvporusuario.jsp";
	public static final String PAGE_GET_OCORRENCIA_CV = "operacoes/getocorrenciacv.jsp";
	public static final String PAGE_SET_ENDPOINT = "operacoes/setendpoint.jsp";
	
	public Operacao(String nome_){
		this.nome = nome_;
	}
	
	public String getNome() {
		return nome;
	}

	public void setPage(String page_) {
		this.page = page_;
	}

	public String getPage() {
		return page;
	}

}
