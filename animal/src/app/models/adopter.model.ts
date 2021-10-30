export class Adopter {
    public get petId(): number {
        return this._petId;
    }
    public set petId(value: number) {
        this._petId = value;
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
    constructor(private _id: number, private _name: string, private _petId: number) {}
}