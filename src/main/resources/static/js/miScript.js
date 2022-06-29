   function validarDatos(usuario, password, cargo) {
      var datos = [{
          id: "001",
          pass: "1234",
          cargo: "1"
        },
        {
          id: "002",
          pass: "1234",
          cargo: "2"
        },
        {
          id: "003",
          pass: "1234",
          cargo: "3"
        },
        {
          id: "004",
          pass: "1234",
          cargo: "4"
        }
      ];

      let esValido = false;

      datos.forEach(d => {
        if (d.id === usuario && d.pass === password && d.cargo === cargo) {
          esValido = true;
        }
      })

      return esValido
    }

    function redireccionar(url) {
      // Si buscan en google veran que hay algun problema que google chrome y cualquier navegador que deriva de chrmium tiene problemas con esto
      // https://www.google.com/search?q=window.location.replace+no+funciona+en+chrome&oq=window.location.replace+no+funciona+en+chrome&aqs=chrome..69i57.5023j0j1&sourceid=chrome&ie=UTF-8

      // En firefox funcionan normalmente las redirecciones

      // Para que funciona en chrome y firefox a la ves hay que usar:
      // setTimeout(() => {window.location.replace(url)});
      // setTimeout(() => {window.location.href = url});
      // setTimeout(() => {window.location.assign(url)});

      // window.location.replace("") => Remplaza en el historial la pagina que redirecciona por la pagina nueva. Por lo tanto si se quiere ir para atras no se puede.
      // window.location.href = "" => En este caso en el historial quedan las dos paginas, por lo tanto si quieren volver a la pagina anterior lo pueden hacer.
      // window.location.assign("") => Funciona igual a window.location.href = ""

      // Encontre la solucion por comentarios que pusieron en un ticket de error que se creo para un framework en github
      // https://github.com/cypress-io/cypress/issues/3994

      setTimeout(() => {
        window.location.href = url
      });
    }

    function login() {
      var varCargo = document.getElementById('perfil').value;
      var varId = document.getElementById('NUMEROIDENTIFICACION').value;
      var varPass = document.getElementById('password').value;

      res = validarDatos(varId, varPass, varCargo);

      if (res == true) {
        if (varCargo == 1) {
          redireccionar('administrador.html');
        }

        if (varCargo == 2) {
          redireccionar('caja.html');
        }

        if (varCargo == 3) {
          redireccionar('cartera.html');
        }

        if (varCargo == 4) {
          redireccionar('inventario.html');
        }

      } else {
        alert("Valores incorrectos!");
      }
    }