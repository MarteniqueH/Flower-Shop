<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNORS UNIVERSITY 
## D287 – JAVA FRAMEWORKS
Welcome to Java Frameworks! This is an opportunity for students to implement user interfaces and learn to leverage existing frameworks, assets, and content for object-oriented programming.
FOR SPECIFIC TASK INSTRUCTIONS AND REQUIREMENTS FOR THIS ASSESSMENT, PLEASE REFER TO THE COURSE PAGE.
## BASIC INSTRUCTIONS
For this project, you will use the Integrated Development Environment (IDE) link in the web links section of this assessment to install the IDE, IntelliJ IDEA (Ultimate Edition). All relevant links are on the course page. Please refer to the course of study for specific links. You will sign up for a free student license using your WGU.edu email address. Please see the “IntelliJ Ultimate Edition Instructions” attachment for instructions on how do this. Next you will download the “Inventory Management Application Template Code” provided in the web links section and open it in IntelliJ IDEA (Ultimate Edition). You will upload this project to a private external GitLab repository and backup regularly. As a part of this, you have been provided with a base code (starting point). 

## SUPPLEMENTAL RESOURCES  
1.	How to clone a project to IntelliJ using Git?

> Ensure that you have Git installed on your system and that IntelliJ is installed using [Toolbox](https://www.jetbrains.com/toolbox-app/). Make sure that you are using version 2022.3.2. Once this has been confirmed, click the clone button and use the 'IntelliJ IDEA (HTTPS)' button. This will open IntelliJ with a prompt to clone the proejct. Save it in a safe location for the directory and press clone. IntelliJ will prompt you for your credentials. Enter in your WGU Credentials and the project will be cloned onto your local machine.  

2. How to create a branch and start Development?

- GitLab method
> Press the '+' button located near your branch name. In the dropdown list, press the 'New branch' button. This will allow you to create a name for your branch. Once the branch has been named, you can select 'Create Branch' to push the branch to your repository.

- IntelliJ method
> In IntelliJ, Go to the 'Git' button on the top toolbar. Select the new branch option and create a name for the branch. Make sure checkout branch is selected and press create. You can now add a commit message and push the new branch to the local repo.

## SUPPORT
If you need additional support, please navigate to the course page and reach out to your course instructor.
## FUTURE USE
Take this opportunity to create or add to a simple resume portfolio to highlight and showcase your work for future use in career search, experience, and education!

# Flower Shop 

## Part C - Customize HTML UI 
- Prompt : Customize the HTML UI for your customer's application 
- File: src/main/resources/templates/mainscreen.html
  - Line 14: Changed <title> to "My Flower Shop"
  - Line 19: Updated <h1> to "Blooms All Around"
  - Line 20: Added <h2> that says "Flower Shop"
  - Line 22: Changed <h2> to "Gift Additions"
  - Lines 29-36: Added unordered list with 5 gift items
  - Line 63: Changed <h2> to "Floral Arrangements"
  - Lines 72-78: Added unordered list with 5 flower items
  - Line 14: Added link to CSS stylesheet
  - Line 21: Added "About Us"
  - Lines 75-105: Updated unordered list of floral arrangements to include images and names
  - Added Images 
  
- File: src/main/resources/static/css/demo.css
  - Lines 2-5: Changed body background color to pink
  - Lines 7-12: Centered <h1> and <h3> text, changed text color
  - Lines 14-18: Centered <h3> text and changed text color
  - Lines 20-32: Styled buttons with pink background, white text and added bold font weight 
- Lines 34–40: .products-offered
  - Made the product list a horizontal layout.
  - Removed bullets, padding, and margin.
  -  Evenly spaced items across row.
    - Lines 42–44: .single-item
      -   Centered content inside each product item.
      - Assigned fixed width (18%) for uniform sizing.
    Lines 49-55: .single-items img
          - Images fill the container width and have fixed height.
          - Used object-fit: cover to prevent distortion.
          - Added 10px pink border around each image.
          - Small margin below the image for spacing.
            - Lines 60–62: #productkeyword
              - Added bottom margin 20px for spacing.
            - Lines65–72: .img-name
                - Centered product names under images.
                - Bold, 20px font, brown color (#5B4A4A).
                - Added slight top padding.
            - Lines 77–79: .single-items:hover
                - Added hover effect:  pink background when user hovers over an item.
## Part D - Add "About" page 
- Prompt: Add an "About" page to describe your customer's company and include navigation to and from
- File: src/main/resources/templates/about.html
  - Created new HTML file about.html for the About Us page
  - Line 6: Linked demo.css stylesheet for styling
  - Line 8: Added <h1> header with text “About”
  - Line 9: Added <a> link to navigate back to main screen (/home)

- File: src/main/resources/templates/mainscreen.html
  - Line 22: Linked "About Us" text to about.html so users can navigate from main screen to About page

- File: src/main/java/com/example/demo/controllers/AboutController.java
  - Line 7: Created new controller class AboutController
  - Line 9: Added @Controller annotation
  - Line 12: Added displayMain() method mapped to /home to return mainscreen.html
  - Line 17: Added displayAbout() method mapped to /about to return about.html

## Part E - Adding Sample inventory for chosen store 
File: src/main/java/com/example/demo/bootstrap/BootStrapData.java
 - Line 53 - 86 Creates and adds all outsource parts to the store and ensures each part is unique  
 - Line 94 - 122 Creates and adds all products to the store and sets their inventory and price amounts 

## Part F - Implementing "Buy Now" button with required funtion
File : src/main/resources/templates/mainscreen.html
- Line 148 - 149 
- Handles GET request to /buyProduct with productId as parameter
- Fetches th e product from the database using product Repositiory 
- Returns "error" if the product is less than 1 in the inventory 
- If the product is avalible, the product inventory will decrease by 1 and save the update inventory value.
- Returns "success" view upon successful purchase 

File: src/main/java/com/example/demo/controllers/BuyProductController.java
- Line 1 - 44  Created a Buy Product Controller

File : src/main/resources/templates/error.html
- Line: 1 - 16 "Purchase Failed!" message with a button to return to the home page

File : src/main/resources/templates/success.html
- Line: 1 - 16  "Purchase Successful!" message with a button to return to the home page


## Part G - Modify the parts to track maximum and minimum inventory
File : src/main/java/com/example/demo/domain/Part.java
Lines 34-36, 53-54, 96-100, 103-104  Added additional fields to the part entity for maximum and minimum inventory.
File: com/example/demo/bootstrap/BootStrapData.java
Lines 58-59, 67-68, 76-77, 85-86, 94-95 Added min and max inventory values for each outsourced part

File: src/main/resources/templates/InhousePartForm.html
File: src/main/resources/templates/OutsourcedPartForm.html
Lines 24 - 25, 25- 26 Added two new input (Min Inventory & Max Inventory) fields for both forms InhousePartForm.html and OutsourcedPartForm.html

Renamed Application.Properties to Floral Arrangements Product Data
File: src/main/java/com/example/demo/controllers/AddInhousePartController.java
Lines 44-47: Added validation to enforce inventory is between minimum and maximum values

File: src/main/java/com/example/demo/controllers/AddOutsourcedPartController.java
Lines 44-47: Added validation to enforce inventory is between minimum and maximum values

## Part H - Add validation for between or at the maximum and minimum fields. 
File: src/main/java/com/example/demo/controllers/AddInhousePartController.java
Lines 44-54: Added validation to display error messages when inventory is below minimum or above maximum when adding parts

File: src/main/java/com/example/demo/controllers/AddOutsourcedPartController.java
Lines 44-54 Added validation to display error messages when inventory is below minimum or above maximum when adding parts

File: src/main/java/com/example/demo/controllers/BuyProductController.java
Lines36-41: Added validation to check if buying a product will lower part inventory below minimum.


## Part I - Added two test for the maximum and minimum fields to the PartTest class in the test Package 
File: src/test/java/com/example/demo/domain/PartTest.java 
Lines 159-172: Added two unit tests (getMinInventory and getMaxInventory) to test the minimum and maximum inventory fields for both InhousePart and OutsourcedPart

## Part J - Remove the class files for unsued validators for clean code
src/main/java/com/example/demo/validators/DeletePartValidator.java (deleted entire file)
- src/main/java/com/example/demo/validators/ValidDeletePart.java (deleted entire file)
- src/main/java/com/example/demo/domain/Part.java (removed @ValidDeletePart annotation)
  Change: Removed unused validator class files and their corresponding annotation interface.
