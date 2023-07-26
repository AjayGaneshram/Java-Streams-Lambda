package com.example.programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


  class Courses {
	 
	public Courses(String course, String domain, int code, int students) {
		this.course = course;
		this.domain = domain;
		this.code = code;
		this.students = students;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getStudents() {
		return students;
	}
	public void setStudents(int students) {
		this.students = students;
	}
	 private String course;
	 private String domain;
	 private int code;
	 private int students;
	@Override
	public String toString() {
		return "Courses [course=" + course + ", domain=" + domain + ", code=" + code + ", students=" + students + "]";
	}
  }
  public class CustomClass {
	public static void main(String[] args) {
		
		List<Courses> courses=List.of
		(
		new Courses("Tamil", "language", 123, 1),
		new Courses("English", "language", 1234, 100),
		new Courses("Maths", "main", 12345, 10),
		new Courses("Science", "main", 12345, 10),
		new Courses("Social", "main", 12345, 10)
				);
		System.out.println(courses.stream().allMatch(course->course.getStudents()>0));
		
		System.out.println(courses.stream().noneMatch(course->course.getStudents()<0));
		
		System.out.println(courses.stream().anyMatch(course->course.getStudents()>20));
		
		System.out.println();
		courses.stream().sorted(Comparator.comparing(Courses::getStudents)).forEach(System.out::println);;
		System.out.println();
		courses.stream().sorted(Comparator.comparing(Courses::getStudents).thenComparing(Courses::getStudents).reversed()).forEach(System.out::println);;

		System.out.println("Limit");
		courses.stream()
		.sorted(Comparator.comparing(Courses::getStudents).thenComparing(Courses::getStudents).reversed())
		.limit(4)
		.forEach(System.out::println);;
        System.out.println();
		
        System.out.println("Skip");
		courses.stream()
		.sorted(Comparator.comparing(Courses::getStudents).thenComparing(Courses::getStudents).reversed())
		.skip(4)
		.forEach(System.out::println);;
        System.out.println();
        
        System.out.println("Take while");
        courses.stream()
		.sorted(Comparator.comparing(Courses::getStudents).thenComparing(Courses::getStudents).reversed())
		.takeWhile(str->str.getCourse().length()>=9)
		.forEach(System.out::println);;
        System.out.println();
        
        System.out.println("Drop while");
        courses.stream()
		.sorted(Comparator.comparing(Courses::getStudents).thenComparing(Courses::getStudents).reversed())
		.dropWhile(str->str.getCourse().length()>=9)
		.forEach(System.out::println);;
        System.out.println();
        
        System.out.println("Max");
        System.out.println(
        courses.stream()
		.sorted(Comparator.comparing(Courses::getStudents).thenComparing(Courses::getStudents).reversed())
		.max(Comparator.comparing(Courses::getStudents)));
        System.out.println();
        
        System.out.println("Min");
        System.out.println(
        courses.stream()
		.sorted(Comparator.comparing(Courses::getStudents).thenComparing(Courses::getStudents).reversed())
		.min(Comparator.comparing(Courses::getStudents)));
        System.out.println();
        
        System.out.println("findFirst");
        System.out.println(
        courses.stream()
		.sorted(Comparator.comparing(Courses::getStudents).thenComparing(Courses::getStudents).reversed())
		.findFirst());
        System.out.println(" without  optional");
        System.out.println(
                courses.stream()
        		.sorted(Comparator.comparing(Courses::getStudents).thenComparing(Courses::getStudents).reversed())
        		.findFirst().orElse(new Courses("optional","6",1,3)));
        System.out.println();
        
        System.out.println("findany");
        System.out.println(
        courses.stream()
		.sorted(Comparator.comparing(Courses::getStudents).thenComparing(Courses::getStudents).reversed())
		.findAny().orElse(new Courses("optional","6",1,3)));
        System.out.println();
        
        System.out.println("Average");
        System.out.println(
        courses.stream()
		.sorted(Comparator.comparing(Courses::getStudents).thenComparing(Courses::getStudents).reversed())
		 .mapToInt(Courses::getStudents)
		 .average());
        System.out.println();
        
        System.out.println("sum");
        System.out.println(
        courses.stream()
		.sorted(Comparator.comparing(Courses::getStudents).thenComparing(Courses::getStudents).reversed())
		 .mapToInt(Courses::getStudents)
		 .sum());
        System.out.println();
        
        System.out.println("sum");
        System.out.println(
        courses.stream()
		.sorted(Comparator.comparing(Courses::getStudents).thenComparing(Courses::getStudents).reversed())
		 .mapToInt(Courses::getStudents)
		 .count());
        System.out.println();
        
        System.out.println("max");
        System.out.println(
        courses.stream()
		.sorted(Comparator.comparing(Courses::getStudents).thenComparing(Courses::getStudents).reversed())
		 .mapToInt(Courses::getStudents)
		 .max());
        System.out.println();
        
        System.out.println("min");
        System.out.println(
        courses.stream()
		.sorted(Comparator.comparing(Courses::getStudents).thenComparing(Courses::getStudents).reversed())
		 .mapToInt(Courses::getStudents)
		 .min());
        System.out.println();
        System.out.println("groupingBy");
        System.out.println(
        courses.stream().collect(Collectors.groupingBy(Courses::getDomain)));;
        System.out.println();
        System.out.println(
                courses.stream().collect(Collectors.groupingBy(Courses::getDomain,Collectors.counting())));;
                System.out.println();
        System.out.println(courses.stream().collect(Collectors.groupingBy(Courses::getDomain,Collectors.mapping(Courses::getCourse, Collectors.toList()))));;
        System.out.println();        
        
        
        
	}
	
}
