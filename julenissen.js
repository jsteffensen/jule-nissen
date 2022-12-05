let persons = [];
let solutions = [];

let i, j, k, m, n, p, q, r, s, t, u, v, x, y;

persons.push({
    'id': 1,
    'name': 'Lilian',
    'group': 1,
    posibilities: []
});
persons.push({
    'id': 2,
    'name': 'Alfred',
    'group': 1,
    posibilities: []
});
persons.push({
    'id': 3,
    'name': 'Lise',
    'group': 2,
    posibilities: []
});
persons.push({
    'id': 4,
    'name': 'Kirsten',
    'group': 3,
    posibilities: []
});
persons.push({
    'id': 5,
    'name': 'Jesper K',
    'group': 3,
    posibilities: []
});
persons.push({
    'id': 6,
    'name': 'Sidsel',
    'group': 4,
    posibilities: []
});
persons.push({
    'id': 7,
    'name': 'Jesper S',
    'group': 4,
    posibilities: []
});

// set possibilities
for (i = 0; i < persons.length; i++) {
    for (j = 0; j < persons.length; j++) {
        if (persons[i].group != persons[j].group) {
            persons[i].posibilities.push(Object.assign({}, persons[j]));
        }
    }
}


let k1, m1, k2, m2, k3, m3, k4, m4, k5, m5, k6, m6, k7, m7;

i = 0;
k1 = Object.assign({}, persons[i]);
for (j = 0; j < persons[i].posibilities.length; j++) {
    m1 = Object.assign({}, persons[i].posibilities[j]);

    k = 1;
    k2 = Object.assign({}, persons[k]);
    for (m = 0; m < persons[k].posibilities.length; m++) {
        if (persons[k].posibilities[m].id != m1.id) {
            m2 = Object.assign({}, persons[k].posibilities[m]);

            n = 2;
            k3 = Object.assign({}, persons[n]);
            for (p = 0; p < persons[n].posibilities.length; p++) {
                if (persons[n].posibilities[p].id != m1.id && persons[n].posibilities[p].id != m2.id) {
                    m3 = Object.assign({}, persons[n].posibilities[p]);

                    q = 3;
                    k4 = Object.assign({}, persons[q]);
                    for (r = 0; r < persons[q].posibilities.length; r++) {
                        if (persons[q].posibilities[r].id != m1.id && persons[q].posibilities[r].id != m2.id && persons[q].posibilities[r].id != m3.id) {
                            m4 = Object.assign({}, persons[q].posibilities[r]);

                            s = 4;
                            k5 = Object.assign({}, persons[s]);
                            for (t = 0; t < persons[s].posibilities.length; t++) {
                                if (persons[s].posibilities[t].id != m1.id && persons[s].posibilities[t].id != m2.id && persons[s].posibilities[t].id != m3.id && persons[s].posibilities[t].id != m4.id) {
                                    m5 = Object.assign({}, persons[s].posibilities[t]);

                                    u = 5;
                                    k6 = Object.assign({}, persons[u]);
                                    for (v = 0; v < persons[u].posibilities.length; v++) {
                                        if (persons[u].posibilities[v].id != m1.id && persons[u].posibilities[v].id != m2.id && persons[u].posibilities[v].id != m3.id && persons[u].posibilities[v].id != m4.id && persons[u].posibilities[v].id != m5.id) {
                                            m6 = Object.assign({}, persons[u].posibilities[v]);

                                            x = 6;
                                            k7 = Object.assign({}, persons[x]);
                                            for (y = 0; y < persons[x].posibilities.length; y++) {
                                                if (persons[x].posibilities[y].id != m1.id && persons[x].posibilities[y].id != m2.id && persons[x].posibilities[y].id != m3.id && persons[x].posibilities[y].id != m4.id && persons[x].posibilities[y].id != m5.id && persons[x].posibilities[y].id != m6.id) {
                                                    m7 = Object.assign({}, persons[x].posibilities[y]);

                                                    let s = [];

                                                    let p1 = [];
                                                    p1.push(k1);
                                                    p1.push(m1);

                                                    let p2 = [];
                                                    p2.push(k2);
                                                    p2.push(m2);

                                                    let p3 = [];
                                                    p3.push(k3);
                                                    p3.push(m3);

                                                    let p4 = [];
                                                    p4.push(k4);
                                                    p4.push(m4);

                                                    let p5 = [];
                                                    p5.push(k5);
                                                    p5.push(m5);

                                                    let p6 = [];
                                                    p6.push(k6);
                                                    p6.push(m6);

                                                    let p7 = [];
                                                    p7.push(k7);
                                                    p7.push(m7);

                                                    s.push(p1);
                                                    s.push(p2);
                                                    s.push(p3);
                                                    s.push(p4);
                                                    s.push(p5);
                                                    s.push(p6);
                                                    s.push(p7);

                                                    solutions.push(s);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

// 2022
filterSolutions(1, 5);
filterSolutions(2, 3);
filterSolutions(3, 6);
filterSolutions(4, 7);
filterSolutions(5, 2);
filterSolutions(6, 4);
filterSolutions(7, 1);

// 2021
filterSolutions(1, 7);
filterSolutions(2, 4);
filterSolutions(3, 5);
filterSolutions(4, 1);
filterSolutions(5, 6);
filterSolutions(6, 3);
filterSolutions(7, 2);

// 2020
filterSolutions(1, 3);
filterSolutions(2, 7);
filterSolutions(3, 2);
filterSolutions(4, 6);
filterSolutions(5, 1);
filterSolutions(6, 5);
filterSolutions(7, 4);

// 2019
// filterSolutions(1, 4);
// filterSolutions(2, 6);
// filterSolutions(3, 7);
// filterSolutions(4, 2);
// filterSolutions(5, 3);
// filterSolutions(6, 1);
// filterSolutions(7, 5);
		
// 2018
// filterSolutions(1, 5);
// filterSolutions(2, 6);
// filterSolutions(3, 1);
// filterSolutions(4, 3);
// filterSolutions(5, 7);
// filterSolutions(6, 4);
// filterSolutions(7, 2);

printSolutions();

function filterSolutions(koeberId, modtagerId) {
    let filteredSolutions = [];
    for (i = 0; i < solutions.length; i++) {
        filter1 = solutions[i][0][0].id == koeberId && solutions[i][0][1].id == modtagerId;
        filter2 = solutions[i][1][0].id == koeberId && solutions[i][1][1].id == modtagerId;
        filter3 = solutions[i][2][0].id == koeberId && solutions[i][2][1].id == modtagerId;
        filter4 = solutions[i][3][0].id == koeberId && solutions[i][3][1].id == modtagerId;
        filter5 = solutions[i][4][0].id == koeberId && solutions[i][4][1].id == modtagerId;
        filter6 = solutions[i][5][0].id == koeberId && solutions[i][5][1].id == modtagerId;
        filter7 = solutions[i][6][0].id == koeberId && solutions[i][6][1].id == modtagerId;

        filter = filter1 || filter2 || filter3 || filter4 || filter5 || filter6 || filter7;

        if (!filter) {
            filteredSolutions.push(solutions[i]);
        }
    }
    solutions = filteredSolutions;
}

function printSolutions() {
    for (i = 0; i < solutions.length; i++) {
        console.log(solutions[i][0][0].name + ' køber til ' + solutions[i][0][1].name);
        console.log(solutions[i][1][0].name + ' køber til ' + solutions[i][1][1].name);
        console.log(solutions[i][2][0].name + ' køber til ' + solutions[i][2][1].name);
        console.log(solutions[i][3][0].name + ' køber til ' + solutions[i][3][1].name);
        console.log(solutions[i][4][0].name + ' køber til ' + solutions[i][4][1].name);
        console.log(solutions[i][5][0].name + ' køber til ' + solutions[i][5][1].name);
        console.log(solutions[i][6][0].name + ' køber til ' + solutions[i][6][1].name);
        console.log('----------------------------');
    }
    console.log('\n' + solutions.length + ' solutions.');
}
