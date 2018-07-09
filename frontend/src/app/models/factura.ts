export class Factura{
    constructor(
        public nombre: string,
        public apellidos: string,
        public email:  string,
        public listadoTelefonos: Array<String>
    ){}
}