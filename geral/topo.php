    <nav class="navbar navbar-inverse navbar-fixed-top surveillon ">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
					<?php
			
					switch(basename(dirname($_SERVER['REQUEST_URI']))){
						case "mod_denuncias":
							$current_module = "Modulo de Denúncias";
						break;
						default:
							$current_module = "Geral";
						break;
					}
					
					
					?>
          <a class="navbar-brand surveillon" href="../inicio.php">Surveillon Camará - <?=$current_module;?></a>
        </div>
       <ul class="nav navbar-nav navbar-right">
        <li><a href="../inicio.php">Inicio</a></li>
        <li><a href="../sair.php">Sair</a></li>
       
      </ul>
      </div>
    </nav>
