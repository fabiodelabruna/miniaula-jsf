package br.senai.sc.aulas.miniaula;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.aulas.miniaula.model.Aluno;
import br.senai.sc.aulas.miniaula.model.Sexo;

@ViewScoped
@ManagedBean(name = "alunoBean")
public class AlunoBean {
	
	private Aluno aluno;
	
	private AlunoDao alunoDao;
	
	private List<Aluno> alunosCadastrados;
	
	@PostConstruct
    public void init() {
		aluno = new Aluno();
		alunoDao = new AlunoDao();
		alunosCadastrados = alunoDao.buscarTodos();
	}
	
	public void salvar() {
		alunoDao.salvar(aluno);
		
		aluno = new Aluno();
		alunosCadastrados = alunoDao.buscarTodos();
    }
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
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
