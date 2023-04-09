import { Component } from '@angular/core';

interface Item {
  name: string
  date: string
  status: string
  price: string
  plan: string
}
@Component({
  selector: 'app-containers',
  templateUrl: './containers.component.html',
  styleUrls: ['./containers.component.css']
})
export class ContainersComponent {


  tableItems: Item[] = [
    {
      name: "Solo learn app",
      date: "Oct 9, 2023",
      status: "Active",
      price: "$35.000",
      plan: "Monthly subscription"
    },
    {
      name: "Window wrapper",
      date: "Oct 12, 2023",
      status: "Active",
      price: "$12.000",
      plan: "Monthly subscription"
    },
    {
      name: "Unity loroin",
      date: "Oct 22, 2023",
      status: "Archived",
      price: "$20.000",
      plan: "Annually subscription"
    },
    {
      name: "Background remover",
      date: "Jan 5, 2023",
      status: "Active",
      price: "$5.000",
      plan: "Monthly subscription"
    },
    {
      name: "Colon tiger",
      date: "Jan 6, 2023",
      status: "Active",
      price: "$9.000",
      plan: "Annually subscription"
    },
  ]

}
