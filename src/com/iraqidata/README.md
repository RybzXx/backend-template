# Project Specification

## Objective ##

Use the `project_submission.clj` file to resolve the tasks.

The objective is to create a backend that returns information about the provided dataset.

Use the first section -Data Analysis- to create helper functions that return the
proper data shapes, feed those into the appropriate endpoints.

## Deadline ##

- The deadline for the project is Thursday, 2024-08-29 at 11:59 p.m.
- **No submissions will be accepted after that date.**

## Endpoints ##

### `/api/sales-trend` ###

Return the sales trend over days.

*Optional*: Set the time format to UNIX time.

``` json
{
  "categories": [
    [
      "2010-12-01",
      "2010-12-02",
      "2010-12-03",
      "2010-12-05",
      "2010-12-06"
    ]
  ],
  "data": [
    [
      12904,
      6815,
      11114,
      7893,
      17678
    ]
  ]
}
```

### `/api/top-customers` ###

Return the top 10 customers by total `:unit-price`.

*Optional*: Make the endpoint interactive with a query or path parameter.

``` json
{
  "data": [
    ["14096", 41376],
    ["15098", 40278],
    ["14911", 31060]
  ]
}
```

## Method of Submission ##

After completing the project, create a zip of the entire project and send it
over e-mail to <adham.a@kapita.iq>

<!-- Local Variables: -->
<!-- jinx-local-words: "backend" -->
<!-- End: -->
