<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
    function validateForm() {
        var fname = document.forms["myForm"]["fname"].value;
        var lname = document.forms["myForm"]["lname"].value;
        var age = document.forms["myForm"]["age"].value;
        var category = document.querySelector('input[name="category"]:checked');
        var subCategory = document.forms["myForm"]["subCategory"];

        // Validate fields with only alphabetical characters
        var nameRegex = /^[a-zA-Z]+$/;

        if (!nameRegex.test(fname)) {
            alert("Please enter a valid First Name (only alphabetical characters).");
            return false;
        }

        if (!nameRegex.test(lname)) {
            alert("Please enter a valid Last Name (only alphabetical characters).");
            return false;
        }
        // Validate age (range from 18 to 80)
        if (isNaN(age) || age < 18 || age > 80) {
            alert("Please enter a valid Age (between 18 and 80).");
            return false;
        }
        if (!category) {
            alert("Please select a Category.");
            return false;
        }

        if (category.value === 'partTime' && subCategory.value === '') {
            alert("Please select a Sub-category for Part Time.");
            return false;
        }
        return true;
    }

    function updateSubCategoryField() {
        var category = document.querySelector('input[name="category"]:checked').value;
        var subCategoryField = document.getElementById('subCategoryField');

        // Activate Sub-category field only if the selected category is "Part Time"
         if (category === 'partTime') {
            subCategoryField.querySelector('option[value="null"]').disabled = true;
            subCategoryField.querySelector('option[value="Data Entry Operator"]').disabled = false;
            subCategoryField.querySelector('option[value="Data Validation"]').disabled = false;
            subCategoryField.querySelector('option[value="Data Integration"]').disabled = false;
            subCategoryField.querySelector('option[value="Coder"]').disabled = false;
            subCategoryField.querySelector('option[value="Data Analyst"]').disabled = false;
        } else {
          
            subCategoryField.querySelector('option[value="null"]').disabled = false;
            subCategoryField.querySelector('option[value="Data Entry Operator"]').disabled = true;
            subCategoryField.querySelector('option[value="Data Validation"]').disabled = true;
            subCategoryField.querySelector('option[value="Data Integration"]').disabled = true;
            subCategoryField.querySelector('option[value="Coder"]').disabled = true;
            subCategoryField.querySelector('option[value="Data Analyst"]').disabled = true;
        }
    }

</script>
</head>
<body style="font-size:20px; text-align: center; background-image: url('hh.jpg'); margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh;">
   
    <form name="myForm" method="post" action="addEmpServlet" onsubmit="validateForm()" style="max-width: 800px; padding: 50px; background-color:white; border: 1px solid #ddd; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);">
        <h1>Add New Employee</h1>
        <table>
            <tr>
                <td> First Name </td>
                <td> <input type="text" name="fname"> </td>
            </tr>
            <tr>
                <td> Last Name </td>
                <td> <input type="text" name="lname"> </td>
            </tr>
            <tr>
                <td> Age </td>
                <td> <input type="text" name="age"> </td>
            </tr>
            <tr>
                <td> Category </td>
                <td> <input type="radio" name="category" value="fullTime" onclick="updateSubCategoryField()"> Full Time </td>
                <td> <input type="radio" name="category" value="partTime" onclick="updateSubCategoryField()"> Part Time </td>
            </tr>
            <tr>
                <td> Sub-category </td>
                <td>
                    <select name="subCategory" id="subCategoryField">
                        <option value="null">null</option>
                        <option value="Data Entry Operator">Data Entry Operator</option>
                        <option value="Data Validation">Data Validation</option>
                        <option value="Data Integration">Data Integration</option>
                        <option value="Coder">Coder</option>
                        <option value="Data Analyst">Data Analyst</option>
                    </select>
                </td>
            </tr>
            
            <tr>
                <td> Date of Joining </td>
                <td> <input type="date" name="dateOfJoining"> </td>
            </tr>
            <tr>
                <td> Mobile Number </td>
                <td> <input type="number" name="mobile"> </td>
            </tr>
            <tr>
                <td>Working Hours </td>
                <td> <input type="number" name="hours"> </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit" onClick="validateForm()" style="background-color:#132743; color: white; border:1px solid black; padding: 10px 20px; border-radius: 3px; cursor: pointer; margin-top:40px;margin-left:80px;">Add</button>
                </td>
            </tr>
        </table>
         <br><br><a href="index.jsp" style="color:#352f44; text-decoration: none; ">Return to Homepage</a>
    </form>
      
</body>
</html>
