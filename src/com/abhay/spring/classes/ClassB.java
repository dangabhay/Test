package com.abhay.spring.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public final class ClassB {

	private ClassA objA;
	private String name;
}
