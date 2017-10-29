<?php 


	session_start();
	include "conexao/conexao.php";

	$email = $_POST ["email"];
	
	

	
	$query = $conexao->prepare("select * from usuario where email = '$email'");

	$query->execute();
	$row = $query->fetch(PDO::FETCH_ASSOC);
	if(!$row || password_verify($_POST['senha'] , $row['senha'])) {

     echo  "<script>
	alert('Usuario logado.');  location.href='inicio.php '</script>";
	}else{
 
  	echo  "<script>
	alert('Senha incorreta.');  location.href='login.php '</script>";
  
	
	}

 ?>