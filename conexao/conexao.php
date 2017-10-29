<?php

 



  
try{
$conexao = new PDO('mysql:host=localhost;dbname=visa','root','34815231'); 
}catch(PDOException $e){
echo 'ERROR: ' . $e->getMessage();
 

} 

?>
  
