
package com.example;

import java.io.*;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class DisplayAttendanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection conn = null;
        try {
            // Get the database connection
            conn = DBUtil.getConnection();

            // SQL query to fetch attendance data
            String query = "SELECT id, username, attendance_date, role, status FROM attendance";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // HTML response to display the attendance data
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Attendance Records</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background: #f0f8ff; margin: 0; padding: 20px; }");
            out.println("h2 { text-align: center; color: #333; }");
            out.println("table { margin: 20px auto; border-collapse: collapse; width: 90%; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); background: #fff; }");
            out.println("table th, table td { padding: 15px; text-align: center; border: 1px solid #ddd; }");
            out.println("table th { background: #0074D9; color: #fff; font-weight: bold; text-transform: uppercase; }");
            out.println("table tr:nth-child(even) { background: #f9f9f9; }");
            out.println("table tr:hover { background: #f1c40f; transition: background-color 0.3s ease-in-out; }");
            out.println("table td { font-size: 1.1em; color: #333; }");
            out.println("a { text-decoration: none; display: inline-block; padding: 10px 20px; background: #0074D9; color: #fff; border-radius: 5px; margin: 20px auto; }");
            out.println("a:hover { background: #0056a3; transition: all 0.3s ease-in-out; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            out.println("<table border='1' cellpadding='10' cellspacing='0'>");
            out.println("<tr><th>id</th><th>Userame</th><th>attendance_Date</th><th>Role</th><th>Status</th></tr>");

            // Loop through the result set and create rows in the table
            while (rs.next()) {
            	int id=rs.getInt("id");
                String username = rs.getString("username");
                Date attendance_date = rs.getDate("attendance_date");
                String role = rs.getString("role");
                String status = rs.getString("status");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + username + "</td>");
                out.println("<td>" + attendance_date + "</td>");
                out.println("<td>" + role + "</td>");
                out.println("<td>" + status + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error: " + e.getMessage() + "</p>");
        } finally {
            // Close the connection
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

