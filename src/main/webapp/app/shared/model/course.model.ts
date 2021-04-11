export interface ICourse {
  id?: number;
  compteId?: number;
  commandeId?: number;
}

export class Course implements ICourse {
  constructor(public id?: number, public compteId?: number, public commandeId?: number) {}
}
