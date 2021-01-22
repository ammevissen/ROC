package com.revature;

public class Person {

		private String firstName;
		private String lastName;
		private int age;
		private double salary;
		private String favoriteColor;
		
		public Person() {
			super();
		}

		public Person(String firstName, String lastName, int age, double salary, String favoriteColor) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.salary = salary;
			this.favoriteColor = favoriteColor;
		}

		
		
		@Override
		public String toString() {
			return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", salary=" + salary
					+ ", favoriteColor=" + favoriteColor + "]";
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public String getFavoriteColor() {
			return favoriteColor;
		}

		public void setFavoriteColor(String favoriteColor) {
			this.favoriteColor = favoriteColor;
		}
		
		
		
		
		
}
