package com.pfa.pack.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity(name = "projects")
@Table(name = "projects")
public class Project implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id", unique = true, nullable = false, precision = 10)
	private Integer projectId;
	
	@Column(name = "title", length = 200)
	private String title;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@Column(name = "status", length = 200)
	private String status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "project")
	private Set<Assignment> assignments;
	
	public Project() {
		
	}
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", title=" + title + ", startDate=" + startDate + ", endDate="
				+ endDate + ", status=" + status + "]";
	}
	
	public Integer getProjectId() {
		return projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}
	
	
	
}