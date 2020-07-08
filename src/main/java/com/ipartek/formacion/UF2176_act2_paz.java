package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UF2176_act2_paz {

	private final static String URL ="jdbc:mysql://localhost/uf2176_act2_paz";
	private final static String USUARIO = "debian-sys-maint";
	private final static String PASS = "o8lAkaNtX91xMUcV";
	
	
	public static void main(String[] args) throws SQLException {
		
		try (Connection con =  DriverManager.getConnection (URL, USUARIO, PASS);){
			
			System.out.println("1. Lista el primer apellido de todos los empleados.");
			System.out.println("----------------------------------------------------------------------------------");
			
			String sql = "SELECT apellido1 from empleados ORDER BY apellido1 ASC LIMIT 500;";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("apellido1"));
			}
			
			System.out.println(" ");
			System.out.println("2. Lista el código de los departamentos de los empleados que aparecen en la tabla empleado.");
			System.out.println("----------------------------------------------------------------------------------");
			
			sql = "SELECT DISTINCT d.codigo 'codigo_departamento' FROM departamento d, empleados e WHERE d.codigo = e.codigo_departamento ORDER BY d.codigo ASC LIMIT 500 ;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getInt("codigo_departamento") );
			}
			
			System.out.println(" ");
			System.out.println("3. Lista el nombre y apellidos de los empleados en una única columna.");
			System.out.println("----------------------------------------------------------------------------------");
			
			sql = "SELECT CONCAT(nombre ,' ', apellido1 ,' ', apellido2 ) 'nombre_completo' FROM empleados ORDER BY nombre ASC LIMIT 500;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("nombre_completo"));
			}
			
			System.out.println(" ");
			System.out.println("4. Lista el nombre de los departamentos y el valor del presupuesto actual ordenado de forma ascendente.");
			System.out.println("----------------------------------------------------------------------------------");
			
			sql = "SELECT nombre 'departamento', presupuesto FROM departamento ORDER BY presupuesto ASC LIMIT 500;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("departamento") + ", presupuesto = " + rs.getInt("presupuesto") );
			}
			
			System.out.println(" ");
			System.out.println("5. Lista el nombre de todos los departamentos ordenados de forma ascendente.");
			System.out.println("----------------------------------------------------------------------------------");
			
			sql = "SELECT nombre 'departamento' FROM departamento ORDER BY nombre ASC LIMIT 500;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("departamento") );
			}
			
			System.out.println(" ");
			System.out.println("6. Devuelve una lista con el nombre de los departamentos y el presupuesto, de aquellos que tienen un presupuesto mayor o igual a 150000 euros.");
			System.out.println("----------------------------------------------------------------------------------");
			
			sql = "SELECT nombre 'departamento' , presupuesto FROM departamento WHERE presupuesto >= 150000 ORDER BY nombre ASC LIMIT 500;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("departamento") + ", presupuesto = " + rs.getInt("presupuesto") );
			}
			
			System.out.println(" ");
			System.out.println("7. Devuelve una lista con el nombre de los departamentos y el presupuesto, de aquellos que tienen un presupuesto entre 100000 y 200000 euros. Sin utilizar el operador BETWEEN.");
			System.out.println("----------------------------------------------------------------------------------");
			
			sql = "SELECT nombre 'departamento' , presupuesto FROM departamento WHERE presupuesto >= 100000 AND presupuesto <= 200000 ORDER BY nombre ASC LIMIT 500;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("departamento") + ", presupuesto = " + rs.getInt("presupuesto") );
			}
			
			System.out.println(" ");
			System.out.println("7*. Devuelve una lista con el nombre de los departamentos y el presupuesto, de aquellos que tienen un presupuesto entre 34000 y 450000 euros. Utilizando el operador BETWEEN.");
			System.out.println("----------------------------------------------------------------------------------");
			
			sql = "SELECT nombre 'departamento' , presupuesto FROM departamento WHERE presupuesto BETWEEN 34000 AND 450000 ORDER BY nombre ASC LIMIT 500;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("departamento") + ", presupuesto = " + rs.getInt("presupuesto") );
			}
			
			System.out.println(" ");
			System.out.println("8. Devuelve una lista con el nombre de los departamentos, gastos y presupuesto, de aquellos departamentos donde los gastos sean menores que el presupuesto del que disponen.");
			System.out.println("----------------------------------------------------------------------------------");
			
			sql = "SELECT nombre 'departamento' , gastos, presupuesto FROM departamento WHERE gastos < presupuesto ORDER BY gastos ASC LIMIT 500;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("departamento") + ", gastos = " + rs.getInt("gastos") + ", presupuesto = " + rs.getInt("presupuesto") );
			}
			
			System.out.println(" ");
			System.out.println("9. Lista los nombres, apellidos y nif de los empleados que trabajan en el departamento 3.");
			System.out.println("----------------------------------------------------------------------------------");
			
			sql = "SELECT e.nombre , e.apellido1 , e.apellido2 , nif FROM empleados e , departamento d WHERE e.codigo_departamento = d.codigo AND d.codigo = 3 ORDER BY nombre ASC LIMIT 500;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("e.nombre") + " " + rs.getString("e.apellido1") + " " + rs.getString("e.apellido2") + " " + rs.getString("nif") );
			}
			
			System.out.println(" ");
			System.out.println("10. Devuelve un listado con los empleados y los datos de los departamentos donde trabaja cada uno.");
			System.out.println("----------------------------------------------------------------------------------");
			
			sql = " SELECT e.nombre , e.apellido1 , e.apellido2 , e.nif , d.nombre 'departamento' , d.presupuesto , d.gastos FROM empleados e LEFT JOIN departamento d ON e.codigo_departamento = d.codigo " + 
					" ORDER BY e.nombre ASC LIMIT 500;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("e.nombre") + " " + rs.getString("e.apellido1") + " " + rs.getString("e.apellido2") 
				+ " " + rs.getString("nif") + " " + rs.getString("departamento") + ", presupuesto = " + rs.getInt("d.presupuesto") + ", gastos = " + rs.getInt("d.gastos") );
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}


