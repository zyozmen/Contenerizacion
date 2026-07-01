package com.zyozmen.products.adapter.in.web;

import com.zyozmen.products.adapter.in.web.dto.MovimientoRequestDTO;
import com.zyozmen.products.adapter.in.web.dto.MovimientoResponseDTO;
import com.zyozmen.products.adapter.in.web.mapper.MovimientoWebMapper;
import com.zyozmen.products.domain.model.Movimiento;
import com.zyozmen.products.domain.port.in.MovimientoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movimientos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Movimientos", description = "API para gestion de movimientos")
public class MovimientoController {

    private final MovimientoUseCase movimientoUseCase;
    private final MovimientoWebMapper movimientoWebMapper;

    @Operation(summary = "Listar todos los movimientos")
    @ApiResponse(responseCode = "200", description = "Lista de movimientos obtenida exitosamente")
    @GetMapping
    public ResponseEntity<List<MovimientoResponseDTO>> listarTodos() {
        List<MovimientoResponseDTO> response = movimientoUseCase.listarTodos()
                .stream()
                .map(movimientoWebMapper::toResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Obtener un movimiento por ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Movimiento encontrado"),
        @ApiResponse(responseCode = "404", description = "Movimiento no encontrado",
                content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping("/{movimientoId}")
    public ResponseEntity<MovimientoResponseDTO> obtenerPorId(
            @Parameter(description = "ID del movimiento", example = "1")
            @PathVariable Long movimientoId) {
        Movimiento movimiento = movimientoUseCase.obtenerPorId(movimientoId);
        return ResponseEntity.ok(movimientoWebMapper.toResponseDTO(movimiento));
    }

    @Operation(summary = "Crear un nuevo movimiento")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Movimiento creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de entrada invalidos",
                content = @Content(schema = @Schema(hidden = true)))
    })
    @PostMapping
    public ResponseEntity<MovimientoResponseDTO> crear(@Valid @RequestBody MovimientoRequestDTO requestDTO) {
        Movimiento creado = movimientoUseCase.crear(movimientoWebMapper.toDomain(requestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(movimientoWebMapper.toResponseDTO(creado));
    }

    @Operation(summary = "Actualizar un movimiento")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Movimiento actualizado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de entrada invalidos",
                content = @Content(schema = @Schema(hidden = true))),
        @ApiResponse(responseCode = "404", description = "Movimiento no encontrado",
                content = @Content(schema = @Schema(hidden = true)))
    })
    @PutMapping("/{movimientoId}")
    public ResponseEntity<MovimientoResponseDTO> actualizar(
            @Parameter(description = "ID del movimiento", example = "1")
            @PathVariable Long movimientoId,
            @Valid @RequestBody MovimientoRequestDTO requestDTO) {
        Movimiento actualizado = movimientoUseCase.actualizar(movimientoId, movimientoWebMapper.toDomain(requestDTO));
        return ResponseEntity.ok(movimientoWebMapper.toResponseDTO(actualizado));
    }

    @Operation(summary = "Eliminar un movimiento")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Movimiento eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Movimiento no encontrado",
                content = @Content(schema = @Schema(hidden = true)))
    })
    @DeleteMapping("/{movimientoId}")
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "ID del movimiento", example = "1")
            @PathVariable Long movimientoId) {
        movimientoUseCase.eliminar(movimientoId);
        return ResponseEntity.noContent().build();
    }
}
