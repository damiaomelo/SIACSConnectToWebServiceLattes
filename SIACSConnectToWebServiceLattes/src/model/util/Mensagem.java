package model.util;

public class Mensagem {


	private static int tamanho = 5;
	
	/** 
	 * ##### 
	 *      MENSAGENS DE ERRO 
	 *      By Filipe Brito (filipesabrito@gmail.com)
	 *      Autorizado Prof. Renato Novais (renatonovais@gmail.com)
	 *      
	 * ##### 
	 * */
	public static final int SEM_ERRO = 0;
	public static final int ERRO_INTERNO = 1;
	public static final int SELECIONE_UMA_OPCAO = 2;
	public static final int CAMPOS_NAO_PODEM_FICAR_EM_BRANCO = 3;
	public static final int CURRICULO_RECUPERADO_COM_SUCESSO = 4;
	

	private static String[] mensagens = new String[tamanho];
	
	
	private static int erroAtual = SEM_ERRO;
	private static String mensagemCustomizada = "";
	
	public static void setMensagemCustomizada(String mensagemCustomizada) {
		Mensagem.mensagemCustomizada = " - "+mensagemCustomizada;
	}

	public static int getErroAtual() {
		return erroAtual;
	}

	public static void setErroAtual(int erroAtual) {
		Mensagem.erroAtual = erroAtual;
		Mensagem.mensagemCustomizada = "";
	}

	static {
		mensagens[SEM_ERRO] = "Não houve erro no sistema";
		mensagens[ERRO_INTERNO] = "Houve um erro interno no sistema. Contate o suporte";
		mensagens[SELECIONE_UMA_OPCAO] = "Selecione uma opção";
		mensagens[CAMPOS_NAO_PODEM_FICAR_EM_BRANCO] = "Pelo menos algum campo deve ser preenchido";
		mensagens[CURRICULO_RECUPERADO_COM_SUCESSO] = "O curriculo foi recuperado com sucesso.<br/>Na sua área de trabalho encontra-se um pasta chamada SIACS com uma subpasta chamada CurriculosCompactados.<br/>O nome do arquivo é igual ao id informado anteriormente .";

	}
	
	public static String getMensagem(int tipoMensagem){
		String msn = mensagens[tipoMensagem];
		if (!mensagemCustomizada.equals("")) 
			msn += mensagemCustomizada;
		return msn;
	}

}
