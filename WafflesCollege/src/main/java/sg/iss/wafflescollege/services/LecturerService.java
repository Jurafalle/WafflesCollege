package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import sg.iss.wafflescollege.model.Lecturer;

public interface LecturerService {

	ArrayList<Lecturer> findAllLecturers();

	Lecturer findLecturerById(String lnric);

	ArrayList<Lecturer> findLecturersByCriteria(Lecturer l);

	int createLecturer(Lecturer l);

	int updateLecturer(Lecturer l);

	int removeLecturer(Lecturer l);

}