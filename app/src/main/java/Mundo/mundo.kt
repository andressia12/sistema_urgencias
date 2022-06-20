package Mundo


import ean.collections.TArrayList
import java.util.*
import kotlin.collections.ArrayList

//ítem 1 : Clase ubicación
class ubicacion_geografica_punto:Comparable<ubicacion_geografica_punto>{

    private var calle = 0
    private var carrera = 0

    constructor()
    constructor(darCalle: Int, darCarrera: Int){
        this.calle = darCalle
        this.carrera = darCarrera
    }

    //Analizadores
    fun getcalle() = this.calle
    fun getcarrera() = this.carrera

    //Modificadores
    fun setcalle(nueva_darCalle: Int){
        if(nueva_darCalle != 0){
            this.calle = nueva_darCalle
        }
    }
    fun setcarrera(nueva_darCarrera: Int){
        if(nueva_darCarrera != 0){
            this.carrera = nueva_darCarrera
        }
    }
    //Función comparable
    override fun compareTo(other: ubicacion_geografica_punto):Int{
        if (this.calle>other.calle){
            return 1
        } else if(other>this){
            return -1
        }else{
            if(this.carrera>other.carrera) {
                return 1
            }
            else if(other>this){
                return -1
            }else{
                return 0
            }
        }
    }

    fun darCalle():Int{
        return 0
    }
    fun darCarrera():Int{
        return 1
    }

}


//Item 2: Función Distancia Manhattan
fun DistanciaManhattan(Inicio: ubicacion_geografica_punto, Final: ubicacion_geografica_punto):Int{
    return (Final.darCalle()-Inicio.darCalle())+(Final.darCarrera()-Inicio.darCarrera())
}

//Item 3: Clase Ambulancia

class ambulancia {

    private var codigo =  0
    private var calle_ambulancia = 0
    private var carrera_ambulancia = 0
    var ambulancia_estado = false
    var accidentado = null

    constructor()
    constructor(codigo:Int,calle_ambulancia:Int,carrera_ambulancia:Int, ambulancia_estado: Boolean){
        this.codigo = codigo
        this.calle_ambulancia = calle_ambulancia
        this.carrera_ambulancia = carrera_ambulancia
        this.ambulancia_estado = ambulancia_estado
        //this.accidentado = accidentado
    }

    //Analizadores

    fun getcodigo() = this.codigo
    fun getcalle_ambulancia() = this.calle_ambulancia
    fun getcarrera_ambulancia() =  this.carrera_ambulancia
    fun ambulancia_estado() = this.ambulancia_estado
    fun getaccidentado() = this.accidentado

    //Método ingresar accidentado

    fun ingresar_accidentado(accidentado: accidentado): Boolean{
        if(ambulancia_estado== false) {
            //accidentado =
            ambulancia_estado= true
        }
        return ambulancia_estado
    }

    //Método para desocupar ambulancia
    fun desocupar_ambulancia() : Boolean{
        if (ambulancia_estado == true){
            accidentado = null
            ambulancia_estado == false
        }
        return ambulancia_estado
    }

    //Cambiar ubicacion ambulancia
    fun cambiar_ubicacion(ubicacion: ubicacion_geografica_punto){
        ubicacion.setcarrera(this.carrera_ambulancia)
        ubicacion.setcalle(this.calle_ambulancia)
    }
}


//Ítem 4 : Clase accidentado

class accidentado : Comparable<accidentado>{

    private var nombre= ""
    private var tipo_accidente = ""
    private  var calle_accidentado = ""
    private var carrera_accidentado = ""

    constructor()
    constructor(nombre:String){
        this.nombre = nombre
        this.tipo_accidente = tipo_accidente
        this.calle_accidentado = calle_accidentado
        this.carrera_accidentado = carrera_accidentado
    }

    //Analizadores

    fun getnombre() = this.nombre
    fun gettipoaccidente() = this.tipo_accidente
    fun getcalleaccidentado() = this.calle_accidentado
    fun getcarreraaccidentado() = this.carrera_accidentado

    override fun compareTo(other: accidentado):Int{
        if (this.nombre != other.nombre){
            return 1
        } else if(other == this){
            return -1
        }
        return 0
    }
}

//Ítem 5 : Clase hospital
class hospital : Comparable<hospital> {

    private var codigo = 1
    private var nombre: String = ""
    private var accidente1: String = ""
    private var accidente2: String = ""
    private var calle_hospital = 0
    private var carrera_hospital = 0
    var lista_pacientes = TArrayList<hospital>()

    constructor()
    constructor(codigo: Int, calle_hospital: Int, carrera_hospital: Int, nombre: String, accidente1: String, accidente2: String) {
        this.codigo = codigo
        this.calle_hospital = calle_hospital
        this.carrera_hospital = carrera_hospital
        this.nombre = nombre
        this.accidente1 = accidente1
        this.accidente2 = accidente2
    }

    override fun compareTo(other: hospital): Int {
        if (this.codigo > other.codigo) {
            return 1
        } else if(other>this){
            return -1
        }else{
            return 0
        }
    }

    fun getcodigo() = this.codigo
    fun getcalle_hospital() = this.calle_hospital
    fun getcarrera_hospital() = this.carrera_hospital
    fun getnombre() = this.nombre
    fun getaccidente1() =  this.accidente1
    fun getaccidente2() =  this.accidente2

//○ Determinar si un paciente con un nombre dado está en ese hospital.

    fun verificar_paciente(nombre: String): Boolean {
        for (i in lista_pacientes) {
            if (i.nombre == nombre) {
                return true
            }
        }
        return false
    }

//○ Dar de alta a un paciente: dado el nombre del paciente, se debe eliminar ese
//paciente del hospital.

    fun dar_alta(nombre: String) {
        for (i in lista_pacientes) {
            if (i.nombre == nombre) {
                lista_pacientes.removeElement(i)

            }
        }
    }

//○ Saber si el hospital atiende un determinado accidente.

    var lista_accidentes = TArrayList<hospital>()

    fun verificar_accidente(accidente: String): Boolean {
        for (i in lista_accidentes) {
            if (i.accidente1 == accidente1 || i.accidente2 == accidente2) {
                return true
            }
        }
        return false
    }

//○ Ingresar un accidentado al hospital. Solo se admite el paciente si no está ya en el
//hospital y el accidente del accidentado es atendido por el hospital.

    fun ingresar_paciente(nombre: String, accidente: String) {
        if (verificar_paciente(nombre) == false && verificar_accidente(accidente) == true) {
            //lista_pacientes.add(nombre)
        }
    }
}

//ítem 6 patron singleton sistema de urgencias

object SistemaUrgencias{

    var lista_hospitales = TArrayList<hospital>()
    var lista_ambulancias = TArrayList<ambulancia>()


    //Verificar si ambulancia ya existe
    fun verificar_ambulancia(codigo: Int):Boolean{
        lista_ambulancias.find { it.getcodigo() == codigo }
        if (lista_ambulancias.filter { it.getcodigo() == codigo }.count() == 1){
            return true
        }
        return false
    }

    //Método agregar ambulancia
    fun agr_ambulancia(codigo: Int, calle_ambulancia: Int, carrera_ambulancia: Int, ambulancia_estado: Boolean){
        var a = verificar_ambulancia(codigo)
        if(a == false){
            lista_ambulancias.add(ambulancia(codigo,calle_ambulancia,carrera_ambulancia,ambulancia_estado))
        }
    }

    //Mostrar ambulancias
    fun codigos_ambulancias():ArrayList<Int>{
        require(!lista_ambulancias.isEmpty)
        var codigos = ArrayList<Int>()
        for (i in lista_ambulancias){
            codigos.add(i.getcodigo())
        }
        return codigos
    }

    //Método verificar si hospital ya existe
    fun verificar_hospital(codigo: Int):Boolean{
        lista_hospitales.find { it.getcodigo() == codigo }
        if (lista_hospitales.filter { it.getcodigo() == codigo }.count() == 1){
            return true
        }
        return false
    }

    //Método agregar Hospital
    fun agregar_hospital(codigo: Int, calle_hospital: Int, carrera_hospital: Int, nombre: String, accidente1: String,accidente2: String){
        var a = verificar_ambulancia(codigo)
        if(a == false){
            lista_hospitales.add(hospital(codigo,calle_hospital,carrera_hospital, nombre, accidente1, accidente2))
        }
    }

    //Método Ocurrio accidente

    fun ocurrio_accidente(accidentado: accidentado):Boolean?{

        for (i in lista_ambulancias){
            if(i.ambulancia_estado == false){
                //accidentado.compareTo(i.getcarrera_ambulancia(accidentado.getcarreraaccidentado()))
                //accidentado.compareTo(i.getcalle_ambulancia(accidentado.getcalleaccidentado()))
            }else{
                return null
            }
        }
        return null
    }

    // Método actualizar ubicación ambulancia

    fun actualizar_ubicacion_ambulancia(ambulancia: ambulancia, codigo_ambulancia: Int, calle_actual_ambulancia: Int,carrera_actual_ambulancia: Int){

        var a = lista_ambulancias.find { it.getcodigo() == codigo_ambulancia }
        if (ambulancia.ambulancia_estado == false){
            var act_ubi = a?.cambiar_ubicacion(ubicacion_geografica_punto(calle_actual_ambulancia,carrera_actual_ambulancia))
        }
    }

    // Método asignar un accidentado
    fun asignar_accidentado( ambulancia: ambulancia){
        if (ambulancia.ambulancia_estado == false){
            ambulancia.ambulancia_estado = false
        }else{
            ambulancia.ambulancia_estado = true
        }

    }

    //Método buscar hospital para ambulancia

    fun buscar_hospital_ambulancia(ambulancia: ambulancia, accidentado: accidentado): String? {
        if (ambulancia.ambulancia_estado == true) {
            var b = lista_hospitales.find { it.verificar_accidente(accidentado.gettipoaccidente()) }
            return b.toString()
        } else {
            return null
        }
    }

    //Método llegada ambulancia a hospital

    fun llegada_ambulancia(hospital: hospital, ambulancia: ambulancia,accidentado: accidentado):Boolean?{
        if (ambulancia.ambulancia_estado == true){
            var a = lista_hospitales.find { it.verificar_paciente(accidentado.getnombre()) }
            if (a == null){
                return false
            }else{
                var ing = hospital.ingresar_paciente(accidentado.getnombre(),accidentado.gettipoaccidente())
                var pos =
                    return true
            }
        }else{
            return false
        }
    }

    //Método dar de alta accidentado

    fun dar_alta_accidentado(){

    }

    //



}











