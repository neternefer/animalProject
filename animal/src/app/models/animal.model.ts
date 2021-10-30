export class Animal {
    public get available(): boolean {
        return this._available;
    }
    public set available(value: boolean) {
        this._available = value;
    }
    public get age(): number {
        return this._age;
    }
    public set age(value: number) {
        this._age = value;
    }
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    constructor(private _id: number, private _name: string, private _age: number, private _available: boolean) {

    }
}