import Column from "./column";

export default class TableDataSource {

  data: string[][];
  columns: Column[];

  constructor(columns: Column[], data: string[][]) {
    this.columns = columns;
    this.data = data;
  }

}
