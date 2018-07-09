export class User{
    constructor(
        public id: number,
        public userName: string,
        public password:  string,
        public passOld:  string,
        public passCkeck:  string
    ){}
}