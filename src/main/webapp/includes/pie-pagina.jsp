<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</main>


      <footer id="footer" class="pt-4 my-md-5 pt-md-5 border-top">
        <div class="row">
          <div class="col-3 col-sm">
            <a href="https://es-es.facebook.com/" target="_blank" class="logo"><i class="fab fa-facebook-square"></i></a>
            <a href="https://twitter.com/login?lang=es" target="_blank" class="logo"><i class="fab fa-twitter-square"></i></a>
            <small class="d-block mb-3 text-muted">&copy; 2020</small>
          </div>   
          <div class="col-9 col-sm">
            <h6>Acerca de Nosotros</h6>
            <ul class="list-unstyled text-small">
              <li><a class="text-muted" href="#">Politica Privacidad</a></li>
              <li><a class="text-muted" href="mailto: super@supermercado.es" target="_blank">Contacto</a></li>
              <li><a class="text-muted" href="#">Localización</a></li>
            </ul>
          </div>
        </div>
      </footer>
    
    <div id="boton">
        <button type="button" class="btn btn-outline-warning d-block d-sm-block d-md-none">
            <a href="#top">Subir</a>
        </button>
    </div>


       <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
      integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
  </script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
      integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
  </script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
      integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous">
  </script>

  <!-- datatables -->
  <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

  <!-- custom js -->
  <script>
      // ejecuta la funcion cuando todo el documento de html DOM este listo y cargado
      $(document).ready(function() {
          // seleccion por id => #example y ejecuta el plugin .DataTable();
          $('#tabla').DataTable();
      });
  </script> 
</body>
</html>