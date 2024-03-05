<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Response Page</title>
<style>
.container
{
   width:50%;
   background-color:#8db9ca;
   height:400px;
   border-radius:5px;
   border:1px solid blue;
}
.headline
{
   text-align:center;
   color:blue;
   font-size:20px;
}
.content
{
  font-size:15px;
  color:white;
}
.title,.footer
{
   font-size:20px;
}
</style>
</head>
<body>
      <div class="container">
       
       <div class="title">
         Hello, ${patient.name}
       </div><br>
       <div class="headline">
         Patient Record Saved With The Details Below
       </div>
       <div class="content">
        
           <pre>
           Patient Id:${patient.id}
           Patient Name:${patient.name}
           Patient Age:${patient.age}
           Patient Address:${patient.address}
           Patient Aadhar:${patient.aadhar}
           Patient Mobile No:${patient.mobNo}
           Patient Pincode:${patient.pincode}
           Patient Mail:${patient.email}
           </pre>
        </div> 
        <div class="footer">
           Thanks & Regards<br>${patient.name}
        </div>
      
</body>
</html>