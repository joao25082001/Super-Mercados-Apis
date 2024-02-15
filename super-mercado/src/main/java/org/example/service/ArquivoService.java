package org.example.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.DTO.venda.ItensRetornoVendaDTO;
import org.example.entity.ItemVenda;
import org.example.entity.Produto;
import org.example.entity.Venda;
import org.example.repository.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ArquivoService extends IOException {
    @Autowired
    ItemVendaRepository itemVendaRepository;
    @Autowired
    VendaService vendaService;
    @Autowired
    ControleProdutoService controleService;
    @Autowired
    ProdutoService produtoService;
    private List<Produto> produtos;


    public ItensRetornoVendaDTO teste(MultipartFile excel, Long venda) {
        Venda vendaExiste = vendaService.verificaVendaExiste(venda);
        List<ItemVenda> itens = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();
        BigDecimal valorApagar = BigDecimal.ZERO;
        List<String> codigos = new ArrayList<>();
        List<Integer> quantidade = new ArrayList<>();
        List<String> cpfCliete = new ArrayList<>();
        List<String> cpfFuncionario = new ArrayList<>();
        List<String> datas = new ArrayList<>();
        XSSFWorkbook vendas = null;
        try {
            vendas = new XSSFWorkbook(excel.getInputStream());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        XSSFSheet info = vendas.getSheetAt(0);
        Iterator<Row> rowIterator = info.iterator();
        int linha = 0;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            if (linha > 0) {
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if(!cellIsNotEmpty(cell)){
                        continue;
                    }
                    switch (cell.getColumnIndex()) {
                        case 0:
                            System.out.println(cell.getCellType());
                            System.out.println("Código " + cell.getStringCellValue());
                            codigos.add(cell.getStringCellValue());
                            break;
                        case 1:
                            System.out.println(cell.getCellType());
                            System.out.println("quantidade vendida " + cell.getNumericCellValue());
                            quantidade.add((int) cell.getNumericCellValue());
                            break;
                        case 2:
                            System.out.println(cell.getCellType());
                            if (cell.getCellType() == CellType.NUMERIC) {
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                String dataFormatada = sdf.format(cell.getDateCellValue());
                                System.out.println("DATA DA COMPRA " + dataFormatada);
                                datas.add(dataFormatada);
                            } else {
                                System.out.println("A célula não contém uma data válida.");
                                datas.add(""); // Ou adicione um valor padrão para datas inválidas
                            }
                        case 3:
                            System.out.println(cell.getCellType());
                            cell.setCellType(CellType.STRING);
                            System.out.println("CPF do cliente " + cell.getStringCellValue());
                            cpfCliete.add(cell.getStringCellValue());
                            break;
                        case 4:
                            System.out.println(cell.getCellType());
                            cell.setCellType(CellType.STRING);
                            System.out.println("CPF do funcionario " + cell.getStringCellValue());
                            cpfFuncionario.add(cell.getStringCellValue());
                            break;

                    }
                }
            }
            linha++;
        }
        for (int i = 0; i < quantidade.size(); i++) {
            for (int j = 1;j < quantidade.get(i); j++) {
                if (quantidade.get(i) > 1) {
                    codigos.add(codigos.get(i));
                }
            }
        }


        for (int i = 0; i < codigos.size(); i++) {
            ItemVenda item = new ItemVenda();
            BigDecimal valorProduto = (controleService.buscaControleProdutoByCodigo(codigos.get(i)).getIdProduto().getValor());
            item.setControleProduto(controleService.buscaControleProdutoByCodigo(codigos.get(i)));
            item.setVenda(vendaExiste);
            itens.add(item);
            valorApagar = valorApagar.add(valorProduto);
            produtos.add(controleService.buscaControleProdutoByCodigo(codigos.get(i)).getIdProduto());
        }
        itemVendaRepository.saveAll(itens);
        try {
            excel.getInputStream().close();
            return new ItensRetornoVendaDTO(
                    itens.get(0).getVenda().getDataHora(),
                    cpfCliete.get(0),
                    vendaExiste.getJornada().getFuncionario().getCpf(),
                    produtos, valorApagar.setScale(2)
            );
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
    private boolean cellIsNotEmpty(Cell cell) {
        return cell != null && cell.getCellType() != CellType.BLANK;
    }

}




