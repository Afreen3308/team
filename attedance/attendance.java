<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Attendance Marking Page</title>
</head>
<style>
      body {
        font-family: "Georgia", serif;
        background-size: cover;
        color: white;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
      }
     form {
         background: purple;
        padding: 40px;
        border-radius: 15px;
        box-shadow: grey;
        width: 590px;
        text-align: left;
        margin-left:100px;
        margin-bottom:8px;
        box-shadow:white;
      }

      .title {
          color:black;
          align-items: center;
          padding:50px;
          margin-bottom:700px;
          margin-left:150px;
          margin-right:10px;
          font-size:50px;
          position:absolute;
          justify-content:center;
      }

      input {
       background-color: lavender;
        text-color: black;
        width: 100%;
        padding: 10px;
        margin: 10px 10px;
        margin-right:900px;
        border-radius: 9px;
        font-size: 20px;
      }

     
    select{
     background-color: lavender;
        text-color: black;
        width: 100%;
        padding: 10px;
        margin: 10px 10px;
        margin-right:900px;
        border-radius: 9px;
        font-size: 20px;
    }
    label{
    font-size:20px;
      color:white;
    }
    select:hover {
        background-color: light lavender;
        transform: scale(1.05);
      }
      input[type="text"]:hover {
        background-color: light lavender;
        transform: scale(1.05);
      }      
      input[type="date"]:hover {
        background-color: light lavender;
        transform: scale(1.05);
      }    
      input[type="password"]:hover {
        background-color: light lavender;
        transform: scale(1.05);
      }      
    
      input[type="submit"] {
        background-color: green;
        color: white;
        font-weight: bold;
        width: 100%;
        padding: 10px;
        margin: 10px 10px;
        margin-right:900px;
        cursor: pointer;
        transition: 0.3s;
      }
   input[type="submit"]:hover {
     background-color: light green;
        transform: scale(1.08);
   }
</style>
<body>
<section class="title">
    <h1>Attendance Marking Page</h1>
    </section>
    <form method="post" action="AttendanceServlet?action=markAttendance">
      <label for="username">UserName:</label>
        <input type="text" name="username" placeholder="Enter the username" required><br><br>

        <label for="attendance_date">Date:</label>
        <input type="date" name="attendance_date" placeholder="Enter the Date" required><br><br>
        
        <label for="role">Role:</label>
        <select name="role" required>
            <option value="teacher">Teacher</option>
            <option value="student">Student</option>
        </select><br><br>
        
        <label for="status">Status:</label>
        <select name="status">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br>
        <input type="submit" value="Mark Attendance">
    </form>
</body>
</html>
