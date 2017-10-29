<?php 
  function echoActiveClassIfRequestMatches($requestUri)
	{	
	    $current_file_name = basename($_SERVER['REQUEST_URI'], ".php");

	    if ($current_file_name == $requestUri)
	        echo 'class = "active surveillon"';
	}
	?>
<div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li <?php echoActiveClassIfRequestMatches("denuncias"); ?>><a href="../mod_denuncias/denuncias.php" style="font-weight: 900;
	 color: white; background-color:#04B486; ">Denuncias</a></li>
          </ul>
				<ul class="nav nav-sidebar">
				<li class="l1" style="text-align:center;">Admin</li>
				<li <?php echoActiveClassIfRequestMatches("casos"); ?>><a href="../geral/casos/index.php" style="font-weight: 900;
	 color: #A4A4A4">Casos</a></li>
				<li <?php echoActiveClassIfRequestMatches("bairros"); ?>><a href="../geral/bairro/index.php" style="font-weight: 900;
	 color: #A4A4A4;">Bairros</a></li>
				<li <?php echoActiveClassIfRequestMatches("visita"); ?>><a href="../geral/visita/index.php" style="font-weight: 900;
	 color: #A4A4A4;">Visitas</a></li>
            <li <?php echoActiveClassIfRequestMatches("usuarios"); ?>><a href="../geral/usuario/index.php" style="font-weight: 900;
	 color: #A4A4A4;">Usuários</a></li>
					</ul>
</div>
