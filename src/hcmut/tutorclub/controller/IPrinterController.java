package hcmut.tutorclub.controller;

import hcmut.tutorclub.model.printer.CoverLetter;
import hcmut.tutorclub.model.printer.Letter;

public interface IPrinterController {
	
	void printCoverLetter(CoverLetter coverLetter);
	void printFrontLetter(Letter letter);
	void printBackLetter();

}
