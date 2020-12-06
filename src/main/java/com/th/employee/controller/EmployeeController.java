package com.th.employee.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.th.employee.model.Books;
import com.th.employee.service.BooksService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//mark class as Controller
@RestController
@RequestMapping("/api/employees")
public class EmployeeController 
{
	//autowire the BooksService class
	@Autowired
	BooksService booksService;
	
	//creating a get mapping that retrieves all the books detail from the database 
	@GetMapping("/getEmployee")
	@ApiOperation(value="Find employees by id",notes="Provide an id to get employee information",response=Books.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	private List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}
	
	//creating a get mapping that retrieves the detail of a specific book
	@GetMapping("/book/{bookid}")
	@ApiOperation(value="Find employees by id",notes="Provide an id to get employee information",response=Books.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	private Books getBooks(@PathVariable("bookid") int bookid) {
		return booksService.getBooksById(bookid);
	}
	
	//creating a delete mapping that deletes a specified book
	@DeleteMapping("/book/{bookid}")
	@ApiOperation(value="Find employees by id",notes="Provide an id to get employee information",response=Books.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	private void deleteBook(@PathVariable("bookid") int bookid) {
		booksService.delete(bookid);
	}
	
	//creating post mapping that post the book detail in the database
	@PostMapping("/book")
	@ApiOperation(value="Find employees by id",notes="Provide an id to get employee information",response=Books.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	private String saveBook(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books.getBookid();
	}
	
	//creating put mapping that updates the book detail 
	@PutMapping("/book")
	@ApiOperation(value="Find employees by id",notes="Provide an id to get employee information",response=Books.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	private Books update(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books;
	}
}
