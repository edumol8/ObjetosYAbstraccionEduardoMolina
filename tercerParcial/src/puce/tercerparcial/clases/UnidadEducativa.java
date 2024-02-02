package puce.tercerparcial.clases;

import java.util.List;

public class UnidadEducativa {
	
	private String nombreUnidadEducativa;
	
	private List<Curso> cursosUnidadEducativaCursos;
	private List <Candidato> candidatosUnidadEducativaCandidatos;
	
	

	//set y getters
	public String getNombreUnidadEducativa() {
		return nombreUnidadEducativa;
	}

	public void setNombreUnidadEducativa(String nombreUnidadEducativa) {
		this.nombreUnidadEducativa = nombreUnidadEducativa;
	}

	public List<Curso> getCursosUnidadEducativaCursos() {
		return cursosUnidadEducativaCursos;
	}

	public void setCursosUnidadEducativaCursos(List<Curso> cursosUnidadEducativaCursos) {
		this.cursosUnidadEducativaCursos = cursosUnidadEducativaCursos;
	}

	public List <Candidato> getCandidatosUnidadEducativaCandidatos() {
		return candidatosUnidadEducativaCandidatos;
	}

	public void setCandidatosUnidadEducativaCandidatos(List <Candidato> candidatosUnidadEducativaCandidatos) {
		this.candidatosUnidadEducativaCandidatos = candidatosUnidadEducativaCandidatos;
	}

}
