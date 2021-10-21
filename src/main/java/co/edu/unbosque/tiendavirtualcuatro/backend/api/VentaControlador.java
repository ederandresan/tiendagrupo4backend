package co.edu.unbosque.tiendavirtualcuatro.backend.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtualcuatro.backend.dao.ClienteDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.dao.UsuarioDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.dao.VentaDAO;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Cliente;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Producto;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Usuario;
import co.edu.unbosque.tiendavirtualcuatro.backend.model.Venta;
import co.edu.unbosque.tiendavirtualcuatro.backend.servicios.VentaServicio;

@RestController
@RequestMapping("/ventas")
public class VentaControlador {

  private VentaServicio ventaServicio;

  /**
   * @param ventaServicio
   */
  public VentaControlador(VentaServicio ventaServicio) {
    super();
    this.ventaServicio = ventaServicio;
  }

  @GetMapping
  public ResponseEntity<List<Venta>> getVentas() {
    return ResponseEntity.ok(this.ventaServicio.getVentas());
  }
  
  @PostMapping
  public ResponseEntity<Venta> postVenta(@RequestBody Venta venta) {
    return ResponseEntity.ok(this.ventaServicio.guardarVenta(venta));
  }

}
