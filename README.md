# LibraryManagementSystem
PGDCA Project


This is the source code for the project done as part of the PGDCA course under Annamalai University.

The project was completed under the guidence of <b>Vipin Nittoor</b>, <i>Lead-Education Training & Assessment, Infosys Ltd., Mangalore</i>.

<h1>How to import and run</h1>

<p>Follow the below steps in Spring ToolSuite IDE:</p>
<ul>
  <li>Spring Tool Suite ==> File -->  Import from Git --> clone URI</li>
  <li>Enter <i>https://github.com/ajaydsouza779/LibraryManagementSystem.git</i> and click Next. Then import as General project.</li>
  <li>Once the project is downloaded successfully, right click on the downloaded project and click configure --> Convert to Maven project.</li>
  <li>After the IDE converted project to maven structure, on right click on project you will see Maven option. Click on Maven --> Update Project </li>
  <li>The above steps may give some errors. Follow the instructions in next paragraph below to resolve them.</li>
  <li>Right click --> Run --> Run as Maven Install. This will compile the code and show if any errors. Follow the instructions below to resolve if any errors.</li>
  <li>Right click --> Run --> Run as Spring Boot App. This will run the application in internal server and provide the port - 8800 in console.</li>
  <li>Open the browser and type htttp://localhost:8800 . The library system will show up.</li>  
 </ul>

<hr>

 <p>Follow below steps to resolve the errors</p>
 <ul>
 <li>Download lombok jar from the url: https://projectlombok.org/download . Click on the jar and specify the path of STS.exe. Click install. This will install addon on the STS for lombok jar.</li>
 </ul>
 
 <hr>
  <p>Follow below steps to add the project dependencies</p>
 <ul>
 <li>The images for the library system are mapped to the localhost apache tomcat server. So to see the images, run the apache tomcat server and place he images under the WebApps--> LMSMEDIA folder. You should be able to see your images under http://localhost:8080/LMSMEDIA/<imageName>.jpg</li>
 <li>The application properties (https://github.com/ajaydsouza779/LibraryManagementSystem/blob/master/src/main/resources/application.properties) are configured to read from mysql db. You can configure it to your own database and update the application properties to match it. </li>
 <li>Upload the initial book data to mysql as provided under https://github.com/ajaydsouza779/LibraryManagementSystem/tree/master/dbdump . Update the imageUrl's to map the one set up in localhost.</li>
 </ul>
