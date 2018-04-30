package com.kurromat.hikingmetrics.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Person {

	@NonNull
	@Id
	private String name;
	@NonNull
	private int count;
}
