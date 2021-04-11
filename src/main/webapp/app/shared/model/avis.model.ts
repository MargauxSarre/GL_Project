export interface IAvis {
  id?: number;
  note?: number;
  description?: string;
  courseId?: number;
}

export class Avis implements IAvis {
  constructor(public id?: number, public note?: number, public description?: string, public courseId?: number) {}
}
