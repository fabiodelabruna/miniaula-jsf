package br.senai.sc.aulas.miniaula.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import br.senai.sc.aulas.miniaula.AlunoDao;
import br.senai.sc.aulas.miniaula.model.Aluno;
import br.senai.sc.aulas.miniaula.model.Sexo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "alunoBean")
public class AlunoBean {
	
	// Objeto que será feito o binding com os campos da tela
	private Aluno aluno;
	
	// Classe de acesso ao banco de dados
	private AlunoDao alunoDao;
	
	// Lista com os alunos cadastrados no banco de dados
	private List<Aluno> alunosCadastrados;
	
	@PostConstruct
    public void init() {
		aluno = new Aluno();
		alunoDao = new AlunoDao();
		alunosCadastrados = alunoDao.buscarTodos();
	}
	
	public void salvar() {
		if (aluno.getId() == null) {
			alunoDao.salvar(aluno);
		} else {
			alunoDao.alterar(aluno);
		}
		
		aluno = new Aluno();
		alunosCadastrados = alunoDao.buscarTodos();
		addMessage("Aluno salvo com sucesso!", FacesMessage.SEVERITY_INFO);
    }
	
	public void excluir() {
		alunoDao.excluir(aluno);
		aluno = new Aluno();
		alunosCadastrados = alunoDao.buscarTodos();
		addMessage("Aluno excluído com sucesso!", FacesMessage.SEVERITY_INFO);
	}
	
	public void addMessage(String summary, Severity severity) {
        FacesMessage message = new FacesMessage(severity, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public Sexo[] getSexos() {
		return Sexo.values();
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public List<Aluno> getAlunosCadastrados() {
		return alunosCadastrados;
	}
	
}
