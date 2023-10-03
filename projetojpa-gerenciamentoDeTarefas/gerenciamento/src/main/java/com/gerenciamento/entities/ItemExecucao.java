package com.gerenciamento.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table (name = "ItemExecucao")
public class ItemExecucao {
		
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column 
		@NotNull
		@NotBlank
		private double percentual;
		
		@Column 
		@NotNull
		@NotBlank
		private String descricao;
		
		@Column 
		@NotNull
		@NotBlank
		private String dataExecucao;
		
		
		
		public Long getId() {
			return id;
		}
		public void setId (Long id) {
			this.id = id;
		}
		public double getPercentual() {
			return percentual;
		}
		public void setPercentual (double percentual) {
			this.percentual = percentual;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao (String descricao) {
			this.descricao = descricao;
		}
		public String getDataExecucao() {
			return dataExecucao;
		}
		public void setDataExecucao (String dataExecucao) {
			this.dataExecucao = dataExecucao;
		}

}
