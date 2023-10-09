<!DOCTYPE html>
<html>
<head>
  <title>Registration</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/materia/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="card">
        <div class="card-header">Registration</div>
        <div class="card-body">
          <form action="register" method="post">
            <div class="form-group">
              <label for="newUsername">Username:</label>
              <input type="text" class="form-control" id="newUsername" name="newUsername" required>
            </div>
            <div class="form-group">
              <label for="newPassword">Password:</label>
              <input type="password" class="form-control" id="newPassword" name="newPassword" required>
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>

