package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tasks-list")
public class TasksListServlet extends HttpServlet {

    private TaskRepository taskRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        this.taskRepository = TaskRepository.getTaskRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Task> taskList = taskRepository.all();
        request.setAttribute("tasks", taskList);
        request.getRequestDispatcher("/WEB-INF/tasks-list.jsp").forward(request, response);
    }
}
